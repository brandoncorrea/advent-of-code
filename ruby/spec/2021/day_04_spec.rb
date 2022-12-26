require '2021/day_04'

# https://adventofcode.com/2021/day/4

input_data = input_data 2021, 4
sample_data = sample_data 2021, 4

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
