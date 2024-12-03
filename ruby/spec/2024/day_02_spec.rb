require '2024/day_02'

# https://adventofcode.com/2024/day/2

input_data = input_data 2024, 2
sample_data = sample_data 2024, 2

describe "Advent 2024 Day 2" do
  let(:advent) { Year_2024_Day_2 }

  context "Part 1" do
    it "no reports" do
      expect(advent.part_1 "").to eq 0
    end

    it "blank lines" do
      expect(advent.part_1 "\r\n\t  \n  ").to eq 0
    end

    it "one report gradually increasing" do
      expect(advent.part_1 "1 2 3 4").to eq 1
    end

    it "one report gradually decreasing by 1" do
      expect(advent.part_1 "4 3 2 1").to eq 1
    end

    it "one report gradually increasing by 1, 2, and 3" do
      expect(advent.part_1 "1 2 4 7").to eq 1
    end

    it "one even report" do
      expect(advent.part_1 "1 1 1 1").to eq 0
    end

    it "one report increasing and decreasing once by small amounts" do
      expect(advent.part_1 "1 2 4 3").to eq 0
    end

    it "two reports gradually increasing" do
      expect(advent.part_1 "1 2 3 4\n5 6 7 8").to eq 2
    end

    it "one unsafe level" do
      expect(advent.part_1 "1 2 4 7 11").to eq 0
    end

    it "sample data" do
      expect(advent.part_1 sample_data).to eq 2
    end

    it "input data" do
      expect(advent.part_1 input_data).to eq 479
    end
  end

  context "Part 2" do
    it "no reports" do
      expect(advent.part_2 "").to eq 0
    end

    it "blank lines" do
      expect(advent.part_2 "\r\n\t  \n  ").to eq 0
    end

    it "one report gradually increasing" do
      expect(advent.part_2 "1 2 3 4").to eq 1
    end

    it "one report increasing by 3s" do
      expect(advent.part_2 "1 4 7 10 13").to eq 1
    end

    it "one report gradually decreasing by 1" do
      expect(advent.part_2 "4 3 2 1").to eq 1
    end

    it "one report gradually increasing by 1, 2, and 3" do
      expect(advent.part_2 "1 2 4 7").to eq 1
    end

    it "one even level" do
      expect(advent.part_2 "1 1 1 1").to eq 0
    end

    it "one report increasing and decreasing once by small amounts" do
      expect(advent.part_2 "1 2 4 3").to eq 1
    end

    it "two report increasing and decreasing twice by small amounts" do
      expect(advent.part_2 "1 2 4 3 5 8 7").to eq 0
    end

    it "two reports gradually increasing" do
      expect(advent.part_2 "1 2 3 4\n5 6 7 8").to eq 2
    end

    it "one unsafe level" do
      expect(advent.part_2 "1 2 4 7 11").to eq 1
    end

    it "two unsafe levels" do
      expect(advent.part_2 "1 1 4 7 11").to eq 0
    end

   it "sample data" do
     expect(advent.part_2 sample_data).to eq 4
   end

   it "input data" do
     expect(advent.part_2 input_data).to eq 531
   end
  end
end
