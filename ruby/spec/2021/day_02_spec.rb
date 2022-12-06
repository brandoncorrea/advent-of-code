require '2021/day_02'

# https://adventofcode.com/2021/day/2

input_data = input_data 2021, 2
sample_data = "forward 5\ndown 5\nforward 8\nup 3\ndown 8\nforward 2"

describe "Advent 2021 Day 2" do
  let(:advent) { Year_2021_Day_2 }

  context "Part 1" do
    it "no movements" do
      expect(advent.part_1 "").to eq 0
    end

    it "moves forward 1" do
      expect(advent.part_1 "forward 1").to eq 0
    end

    it "moves down 1" do
      expect(advent.part_1 "down 1").to eq 0
    end

    it "moves forward and down 1" do
      expect(advent.part_1 "forward 1\ndown 1").to eq 1
    end

    it "moves forward 1 and down 2" do
      expect(advent.part_1 "forward 1\ndown 2").to eq 2
    end

    it "sample data" do
      expect(advent.part_1 sample_data).to eq 150
    end

    it "input data" do
      expect(advent.part_1 input_data).to eq 1938402
    end
  end

  context "Part 2" do
    it "doesn't move" do
      expect(advent.part_2 "").to eq 0
    end

    it "moves forward 1" do
      expect(advent.part_2 "forward 1").to eq 0
    end

    it "moves down 1 and forward 1" do
      expect(advent.part_2 "down 1\nforward 1").to eq 1
    end

    it "moves down 2 and forward 1" do
      expect(advent.part_2 "down 2\nforward 1").to eq 2
    end

    it "sample data" do
      expect(advent.part_2 sample_data).to eq 900
    end

    it "input data" do
      expect(advent.part_2 input_data).to eq 1947878632
    end
  end
end
