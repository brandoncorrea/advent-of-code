require '2022/day_06'

# https://adventofcode.com/2022/day/6

input_data = input_data 2022, 6
sample_data_1 = "mjqjpqmgbljsphdztnvjfqwrcgsmlb"
sample_data_2 = "bvwbjplbgvbhsrlpgdmjqwftvncz"
sample_data_3 = "nppdvjthqldpwncqszvftbrmjlhg"
sample_data_4 = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"
sample_data_5 = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"

describe "Advent 2022 Day 6" do
  let(:advent) { Year_2022_Day_6 }

  context "Part 1" do
    it "empty string" do
      expect(advent.part_1("")).to eq 0
    end

    it "'a'" do
      expect(advent.part_1("a")).to eq 1
    end

    it "'aa'" do
      expect(advent.part_1("aa")).to eq 2
    end

    it "'abc'" do
      expect(advent.part_1("abc")).to eq 3
    end

    it "'chocolate'" do
      expect(advent.part_1("chocolate")).to eq 7
    end

    it "sample data" do
      expect(advent.part_1(sample_data_1)).to eq 7
      expect(advent.part_1(sample_data_2)).to eq 5
      expect(advent.part_1(sample_data_3)).to eq 6
      expect(advent.part_1(sample_data_4)).to eq 10
      expect(advent.part_1(sample_data_5)).to eq 11
    end

    it "input data" do
      expect(advent.part_1(input_data)).to eq 1034
    end
  end

  context "Part 2" do
   it "sample data" do
     expect(advent.part_2(sample_data_1)).to eq 19
     expect(advent.part_2(sample_data_2)).to eq 23
     expect(advent.part_2(sample_data_3)).to eq 23
     expect(advent.part_2(sample_data_4)).to eq 29
     expect(advent.part_2(sample_data_5)).to eq 26
   end

   it "input data" do
     expect(advent.part_2(input_data)).to eq 2472
   end
  end
end
