require '2023/day_01'

# https://adventofcode.com/2023/day/1

input_data = input_data 2023, 1
sample_data_part_1 = sample_data 2023, 1
sample_data_part_2 = "two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen"

describe "Advent 2023 Day 1" do
  let(:advent) { Year_2023_Day_1 }

  context "Part 1" do

    it "no values" do
      expect(advent.part_1 "").to eq 0
    end

    it "one digit" do
      expect(advent.part_1 "1").to eq 11
    end

    it "two digits" do
      expect(advent.part_1 "12").to eq 12
    end

    it "two digits separated by a character" do
      expect(advent.part_1 "1a2").to eq 12
    end

    it "three digits separated by a character" do
      expect(advent.part_1 "1a2b3c").to eq 13
    end

    it "multiple lines" do
      expect(advent.part_1 "1\n2").to eq 33
    end

    it "sample data" do
      expect(advent.part_1 sample_data_part_1).to eq 142
    end

    it "input data" do
      expect(advent.part_1 input_data).to eq 54081
    end
  end

  context "Part 2" do
    it "digits" do
      expect(advent.part_2 "1a2b3\nc5c7").to eq 70
    end

    it "one one" do
      expect(advent.part_2 "oneone").to eq 11
    end

    it "two three" do
      expect(advent.part_2 "twothree").to eq 23
    end

    it "four five" do
      expect(advent.part_2 "fourfive").to eq 45
    end

    it "six seven" do
      expect(advent.part_2 "sixseven").to eq 67
    end

    it "eight nine" do
      expect(advent.part_2 "eightnine").to eq 89
    end

    it "digits and words" do
      expect(advent.part_2 "asd1twothreeasd").to eq 13
    end

    it "eightwo" do
      expect(advent.part_2 "eightwo").to eq 82
    end

    it "sample data" do
      expect(advent.part_2 sample_data_part_2).to eq 281
    end

    it "input data" do
      expect(advent.part_2 input_data).to eq 54649
    end
  end
end
