require '2021/day_04'

# https://adventofcode.com/2021/day/4

input_data = input_data 2021, 4
sample_data = "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1

22 13 17 11  0
 8  2 23  4 24
21  9 14 16  7
 6 10  3 18  5
 1 12 20 15 19

 3 15  0  2 22
 9 18 13 17  5
19  8  7 25 23
20 11 10 24  4
14 21 16 12  6

14 21 17 24  4
10 16 15  9 19
18  8 23 26 20
22 11 13  6  5
 2  0 12  3  7"

describe "Advent 2021 Day 4" do
  let(:advent) { Year_2021_Day_4 }

  context "Part 1" do
    it "no boards" do
      expect(advent.part_1 "1, 2, 3\n\n").to eq 0
    end

    it "one board that doesn't win" do
      expect(advent.part_1 "5,6,7\n\n 1  2\n 3  4").to eq 0
    end

    it "one board that wins" do
      expect(advent.part_1 "1,2\n\n 1  2\n 3  4").to eq 14
    end

    it "sample data" do
      expect(advent.part_1 sample_data).to eq 4512
    end

    it "input data" do
      expect(advent.part_1 input_data).to eq 82440
    end
  end

  context "Part 2" do
    it "selects losing board" do
      numbers = "1,2,3,4"
      winner = " 1  2\n 3  4"
      loser = " 2  3\n 4  5"
      expect(advent.part_2 "#{numbers}\n\n#{loser}\n\n#{winner}").to eq 27
    end

    it "sample data" do
      expect(advent.part_2 sample_data).to eq 1924
    end

    it "input data" do
      expect(advent.part_2 input_data).to eq 20774
    end
  end
end
