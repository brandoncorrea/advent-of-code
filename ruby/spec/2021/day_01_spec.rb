require '2021/day_01'

# https://adventofcode.com/2021/day/1

input_data = input_data 2021, 1
sample_data = "199\n200\n208\n210\n200\n207\n240\n269\n260\n263"

describe "Advent 2021 Day 1" do
  let(:advent) { Year_2021_Day_1 }

  context "Part 1" do
    it "no measurements" do
      expect(advent.part_1 "").to eq 0
    end

    it "one measurement" do
      expect(advent.part_1 "200").to eq 0
    end

    it "two of the same measurements" do
      expect(advent.part_1 "200\n200").to eq 0
    end

    it "two measurements decreasing" do
      expect(advent.part_1 "200\n199").to eq 0
    end

    it "two measurements increasing" do
      expect(advent.part_1 "200\n201").to eq 1
    end

    it "three measurements with one increasing" do
      expect(advent.part_1 "200\n201\n200").to eq 1
    end

    it "three measurements with two increasing" do
      expect(advent.part_1 "200\n201\n202").to eq 2
    end

    it "sample data" do
      expect(advent.part_1 sample_data).to eq 7
    end

    it "sample data" do
      expect(advent.part_1 input_data).to eq 1288
    end
  end

  context "Part 2" do
    it "no depths" do
      expect(advent.part_2 "").to eq 0
    end

    it "one depth" do
      expect(advent.part_2 "1").to eq 0
    end

    it "two depths" do
      expect(advent.part_2 "1\n2").to eq 0
    end

    it "three depths" do
      expect(advent.part_2 "1\n2\n3").to eq 0
    end

    it "four depths that do not increase" do
      expect(advent.part_2 "1\n2\n3\n0").to eq 0
    end

    it "four depths with equal windows" do
      expect(advent.part_2 "1\n2\n3\n1").to eq 0
    end

    it "four depths with increasing windows" do
      expect(advent.part_2 "1\n2\n3\n7").to eq 1
    end

    it "sample data" do
      expect(advent.part_2 sample_data).to eq 5
    end

    it "input data" do
      expect(advent.part_2 input_data).to eq 1311
    end
  end
end
