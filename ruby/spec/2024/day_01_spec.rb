require '2024/day_01'

# https://adventofcode.com/2024/day/1

input_data = input_data 2024, 1
sample_data = "3   4
4   3
2   5
1   3
3   9
3   3"

describe "Advent 2024 Day 1" do
  let(:advent) { Year_2024_Day_1 }

  context "Part 1" do
    it "no items" do
      expect(advent.part_1 "").to eq 0
    end

    it "one row with a distance of 1" do
      expect(advent.part_1 "1 2").to eq 1
    end

    it "one row with a distance of 2" do
      expect(advent.part_1 "1 3").to eq 2
    end

    it "two rows with a distance of 1 and 2" do
      expect(advent.part_1 "1 2\n3 5").to eq 3
    end

    it "two unordered rows with a distance of 1 and 2" do
      expect(advent.part_1 "1 5\n3 2").to eq 3
    end

    it "sample data" do
      expect(advent.part_1 sample_data).to eq 11
    end

    it "input data" do
      expect(advent.part_1 input_data).to eq 2086478
    end
  end

  context "Part 2" do
    it "no input" do
      expect(advent.part_2 "").to eq 0
    end

    it "two of the same number" do
      expect(advent.part_2 "2 2").to eq 2
    end

    it "four unordered digits all appearing once" do
      expect(advent.part_2 "1 2\n2 1").to eq 3
    end

   it "sample data" do
     expect(advent.part_2 sample_data).to eq 31
   end

   it "input data" do
     expect(advent.part_2 input_data).to eq 24941624
   end
  end
end
