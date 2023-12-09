require '2023/day_04'

# https://adventofcode.com/2023/day/4

input_data = input_data 2023, 4
sample_data = sample_data 2023, 4

describe "Advent 2023 Day 4" do
  let(:advent) { Year_2023_Day_4 }

  context "Part 1" do
    it "no cards" do
      expect(advent.part_1 "").to eq 0
    end

    it "one matching number" do
      expect(advent.part_1 "Card 1: 1 | 1").to eq 1
    end

    it "two matching numbers" do
      expect(advent.part_1 "Card 1: 1 2 | 1 2").to eq 2
    end

    it "three matching numbers" do
      expect(advent.part_1 "Card 1: 1 2 3 | 1 2 3").to eq 4
    end

    it "three of five matching numbers" do
      expect(advent.part_1 "Card 1: 1 2 3 4 5 | 2 4 5 6 10").to eq 4
    end

    it "sample data" do
      expect(advent.part_1 sample_data).to eq 13
    end

    it "input data" do
      expect(advent.part_1 input_data).to eq 25174
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
