require '2023/day_09'

# https://adventofcode.com/2023/day/9

input_data = input_data 2023, 9
sample_data = sample_data 2023, 9

describe "Advent 2023 Day 9" do
  let(:advent) { Year_2023_Day_9 }

  context "Part 1" do
    it "no history" do
      expect(advent.part_1 "").to eq 0
    end

    it "two ones" do
      expect(advent.part_1 "1 1").to eq 1
    end

    it "incremental sequence" do
      expect(advent.part_1 "1 2").to eq 3
    end

    it "multiples of 2" do
      expect(advent.part_1 "2 4 6").to eq 8
    end

    it "double digits" do
      expect(advent.part_1 "10 20").to eq 30
    end

    it "fibonacci (kinda)" do
      expect(advent.part_1 "1 2 3 5 8").to eq 11
    end

    it "negative doubles" do
      expect(advent.part_1 "-8 -6 -4").to eq -2
    end

    it "sample data" do
      expect(advent.part_1 sample_data).to eq 114
    end

    it "input data" do
      expect(advent.part_1 input_data).to eq 2043183816
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
