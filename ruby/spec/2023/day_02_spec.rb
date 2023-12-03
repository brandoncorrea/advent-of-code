require '2023/day_02'

# https://adventofcode.com/2023/day/2

input_data = input_data 2023, 2
sample_data = sample_data 2023, 2

describe "Advent 2023 Day 2" do
  let(:advent) { Year_2023_Day_2.new(12, 13, 14) }

  context "Part 1" do

    it "plays no games" do
      expect(advent.part_1 "").to eq 0
    end

    it "game 1 is possible with one cube" do
      expect(advent.part_1 "Game 1: 1 blue").to eq 1
    end

    it "game 1 and 2 are possible" do
      expect(advent.part_1 "Game 1: 1 blue\nGame 2: 1 blue").to eq 3
    end

    it "game 1 is impossible, but game 2 is possible" do
      expect(advent.part_1 "Game 1: 15 blue\nGame 2: 1 blue").to eq 2
    end

    it "three games are possible with different colors" do
      expect(advent.part_1 "Game 1: 1 blue\nGame 2: 1 green\nGame 3: 1 red").to eq 6
    end

    it "no games are possible with different colors" do
      expect(advent.part_1 "Game 1: 15 blue\nGame 2: 14 green\nGame 3: 13 red").to eq 0
    end

    it "all games are possible with different colors" do
      expect(advent.part_1 "Game 1: 14 blue\nGame 2: 13 green\nGame 3: 12 red").to eq 6
    end

    it "game is possible with multiple rounds" do
      expect(advent.part_1 "Game 1: 14 blue; 12 green").to eq 1
    end

    it "game is impossible with multiple rounds" do
      expect(advent.part_1 "Game 1: 14 blue; 15 green").to eq 0
    end

    it "game id is 100" do
      expect(advent.part_1 "Game 100: 1 blue").to eq 100
    end

    it "sample data" do
      expect(advent.part_1 sample_data).to eq 8
    end

    it "input data" do
      expect(advent.part_1 input_data).to eq 2683
    end
  end

  context "Part 2" do
    it "played no games" do
      expect(advent.part_2 "").to eq 0
    end

    it "one game with one color each" do
      expect(advent.part_2 "Game 1: 1 blue, 1 red, 1 green").to eq 1
    end

    it "1, 2, 3 game" do
      expect(advent.part_2 "Game 1: 1 blue, 2 red, 3 green").to eq 6
    end

    it "differing color count in second round of a game" do
      expect(advent.part_2 "Game 1: 1 blue, 3 red, 3 green; 2 blue, 1 red, 4 green").to eq 24
    end

    it "two games" do
      expect(advent.part_2 "Game 1: 1 blue, 1 red, 1 green\nGame 2: 2 blue, 1 red, 4 green").to eq 9
    end

    it "sample data" do
      expect(advent.part_2 sample_data).to eq 2286
    end

    it "input data" do
      expect(advent.part_2 input_data).to eq 49710
    end
  end
end
