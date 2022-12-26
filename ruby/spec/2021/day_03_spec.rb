require '2021/day_03'

# https://adventofcode.com/2021/day/3

input_data = input_data 2021, 3
sample_data = sample_data 2021, 3

describe "Advent 2021 Day 3" do
  let(:advent) { Year_2021_Day_3 }

  context "Part 1" do
    it "no diagnostic report" do
      expect(advent.part_1 "").to eq 0
    end

    it "one binary number" do
      expect(advent.part_1 "10011").to eq 228
      expect(advent.part_1 "01100").to eq 228
    end

    it "two of the same binary numbers" do
      expect(advent.part_1 "10011\n10011").to eq 228
    end

    it "three different binary numbers" do
      expect(advent.part_1 "10011\n11011\n01101").to eq 108
    end

    it "sample data" do
      expect(advent.part_1 sample_data).to eq 198
    end

    it "input data" do
      expect(advent.part_1 input_data).to eq 4006064
    end
  end

  context "Part 2" do
    it "no diagnostics" do
      expect(advent.part_2 "").to eq 0
    end

    it "one diagnostic" do
      expect(advent.part_2 "10011").to eq 361
    end

    it "two of the same diagnostic reports" do
      expect(advent.part_2 "10011\n10011").to eq 361
    end

    it "two different diagnostic reports" do
      expect(advent.part_2 "00101\n10011").to eq 95
    end

    it "two complementing numbers" do
      expect(advent.part_2 "10011\n01100").to eq 228
    end

    it "sample data" do
      expect(advent.part_2 sample_data).to eq 230
    end

    it "input data" do
      expect(advent.part_2 input_data).to eq 5941884
    end
  end
end
