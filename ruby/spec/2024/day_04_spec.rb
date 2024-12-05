require '2024/day_04'

# https://adventofcode.com/2024/day/4

input_data = input_data 2024, 4
sample_data = sample_data 2024, 4

describe "Advent 2024 Day 4" do
  let(:advent) { Year_2024_Day_4 }

  context "Part 1" do
    it "no letters" do
      expect(advent.part_1 "").to eq 0
    end

    it "left to right" do
      expect(advent.part_1 "XMAS").to eq 1
    end

    it "after a dud" do
      expect(advent.part_1 "XXMAS").to eq 1
    end

    it "right to left" do
      expect(advent.part_1 "SAMX").to eq 1
    end

    it "backwards surrounded by duds" do
      expect(advent.part_1 "ASAMXA").to eq 1
    end

    it "top to bottom" do
      expect(advent.part_1 "X\nM\nA\nS").to eq 1
    end

    it "bottom to top" do
      expect(advent.part_1 "S\n\A\nM\nX").to eq 1
    end

    it "diagonally top-left to bottom-right" do
      expect(advent.part_1 "X\n.M\n..A\n...S").to eq 1
    end

    it "diagonally top-right to bottom-left" do
      expect(advent.part_1 "...X\n..M\n.A\nS").to eq 1
    end

    it "diagonally bottom-left to top-right" do
      expect(advent.part_1 "...S\n..A\n.M\nX").to eq 1
    end

    it "diagonally bottom-right to top-left" do
      expect(advent.part_1 "S\n.A\n..M\n...X").to eq 1
    end

    it "sample data" do
      expect(advent.part_1 sample_data).to eq 18
    end

    it "input data" do
      expect(advent.part_1 input_data).to eq 2646
    end
  end

  context "Part 2" do
    it "no input" do
      expect(advent.part_2 "").to eq 0
    end

    it "M S and M S" do
      expect(advent.part_2 "M.S\n.A.\nM.S").to eq 1
    end

    it "S S and M M" do
      expect(advent.part_2 "S.S\n.A.\nM.M").to eq 1
    end

    it "missing A" do
      expect(advent.part_2 "S.S\n...\nM.M").to eq 0
    end

    it "M M and S S" do
      expect(advent.part_2 "M.M\n.A.\nS.S").to eq 1
    end

    it "S M and M S" do
      expect(advent.part_2 "S.M\n.A.\nM.S").to eq 0
    end

    it "M S and S M" do
      expect(advent.part_2 "M.S\n.A.\nS.M").to eq 0
    end

    it "sample data" do
      expect(advent.part_2 sample_data).to eq 9
    end

    it "input data" do
      expect(advent.part_2 input_data).to eq 2000
    end
  end
end
