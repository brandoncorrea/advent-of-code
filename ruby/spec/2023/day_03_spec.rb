require '2023/day_03'

# https://adventofcode.com/2023/day/3

input_data = input_data 2023, 3
sample_data = sample_data 2023, 3

describe "Advent 2023 Day 3" do
  let(:advent) { Year_2023_Day_3 }

  context "Part 1" do
    it "empty schematic" do
      expect(advent.part_1 "").to eq 0
    end

    it "one number by itself" do
      expect(advent.part_1 "1").to eq 0
    end

    it "two numbers on the same line" do
      expect(advent.part_1 "12%34").to eq 46
    end

    it "two number by themselves" do
      expect(advent.part_1 "$1\n$2").to eq 3
    end

    it "symbol to the left" do
      expect(advent.part_1 "$1").to eq 1
    end

    it "symbol to the right" do
      expect(advent.part_1 "1$").to eq 1
    end

    it "in between dots" do
      expect(advent.part_1 ".1.").to eq 0
    end

    it "symbol above" do
      expect(advent.part_1 ".#.\n.1.").to eq 1
    end

    it "symbol below" do
      expect(advent.part_1 ".1.\n.#.").to eq 1
    end

    it "symbol lower-left" do
      expect(advent.part_1 ".1.\n#..").to eq 1
    end

    it "symbol lower-right" do
      expect(advent.part_1 ".1.\n..#").to eq 1
    end

    it "symbol upper-left" do
      expect(advent.part_1 "#..\n.1.").to eq 1
    end

    it "symbol upper-right" do
      expect(advent.part_1 "..#\n.1.").to eq 1
    end

    it "symbol upper-right with a 3-digit number" do
      expect(advent.part_1 "....#\n.123.").to eq 123
    end

    it "sample data" do
      expect(advent.part_1 sample_data).to eq 4361
    end

    it "input data" do
      expect(advent.part_1 input_data).to eq 522726
    end
  end

  # context "Part 2" do
  #   it "Solves Part 2" do
  #     expect(advent.part_2 "").to eq -1
  #   end

  #  # it "sample data" do
  #  #   expect(advent.part_2 sample_data).to eq -1
  #  # end

  #  # it "input data" do
  #  #   expect(advent.part_2 input_data).to eq -1
  #  # end
  # end
end
