require '2022/day_04'

# https://adventofcode.com/2022/day/4

describe "Advent 2022 Day 4" do
  let(:advent) { Year_2022_Day_4 }

  context "Part 1" do
    it "no crossovers" do
      expect(advent.part_1("28-29,30-31")).to eq 0
    end

    it "starts and ends on the same section" do
      expect(advent.part_1("28-29,29-31")).to eq 0
    end

    it "one equal assignment" do
      expect(advent.part_1("28-30,28-30")).to eq 1
    end

    it "two equal assignments" do
      expect(advent.part_1("28-30,28-30\n31-44,31-44")).to eq 2
    end

    it "left is a subset of right" do
      expect(advent.part_1("28-30,27-31")).to eq 1
    end

    it "right is a subset of left" do
      expect(advent.part_1("27-31,28-30")).to eq 1
    end

    it "sample data" do
      sample = "2-4,6-8\n2-3,4-5\n5-7,7-9\n2-8,3-7\n6-6,4-6\n2-6,4-8"
      expect(advent.part_1(sample)).to eq 2
    end

    it "input data" do
      expect(advent.part_1(input_data 2022, 4)).to eq 431
    end
  end

  context "Part 2" do
    it "no assignments" do
      expect(advent.part_2("")).to eq 0
    end

    it "no overlaps" do
      expect(advent.part_2("2-4,5-8")).to eq 0
    end

    it "first ends on the next one's start" do
      expect(advent.part_2("2-4,5-8\n10-12,12-13")).to eq 1
    end

    it "second starts before first's end" do
      expect(advent.part_2("2-4,5-8\n10-12,11-13")).to eq 1
    end

    it "first is after second" do
      expect(advent.part_2("13-15,10-12")).to eq 0
    end

    it "first starts before second's end" do
      expect(advent.part_2("11-13,10-12")).to eq 1
    end

    it "first ends after second starts" do
      expect(advent.part_2("9-11,10-12")).to eq 1
    end

    it "second starts before first's end" do
      expect(advent.part_2("2-4,5-8\n10-12,11-13")).to eq 1
    end

    it "sample data" do
      sample = "2-4,6-8\n2-3,4-5\n5-7,7-9\n2-8,3-7\n6-6,4-6\n2-6,4-8"
      expect(advent.part_2(sample)).to eq 4
    end

    it "input data" do
      expect(advent.part_2(input_data 2022, 4)).to eq 823
    end
  end
end
