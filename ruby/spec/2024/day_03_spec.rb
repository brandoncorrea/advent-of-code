require '2024/day_03'

# https://adventofcode.com/2024/day/3

input_data = input_data 2024, 3
sample_data = sample_data 2024, 3

describe "Advent 2024 Day 3" do
  let(:advent) { Year_2024_Day_3 }

  context "Part 1" do
    it "no memory" do
      expect(advent.part_1 "").to eq 0
    end

    it "1 x 1" do
      expect(advent.part_1 "mul(1,1)").to eq 1
    end

    it "2 x 3" do
      expect(advent.part_1 "mul(2,3)").to eq 6
    end

    it "sums multiple instances" do
      expect(advent.part_1 "mul(2,3)mul(1,1)").to eq 7
    end

    it "ignores garbage" do
      expect(advent.part_1 "1mmul(2,3)amull(1,1)mul(1,1))").to eq 7
    end
    
    it "spaces are considered corrupt" do
      expect(advent.part_1 "mul( 2 , 3 )").to eq 0
    end

    it "sample data" do
      input = "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"
      expect(advent.part_1 input).to eq 161
    end

    it "input data" do
      expect(advent.part_1 input_data).to eq 159833790
    end
  end

  context "Part 2" do

    it "no memory" do
      expect(advent.part_2 "").to eq 0
    end

    it "one instruction" do
      expect(advent.part_2 "mul(2,3)").to eq 6
    end

    it "sums multiple instances" do
      expect(advent.part_2 "mul(2,3)mul(1,1)").to eq 7
    end

    it "ignores garbage" do
      expect(advent.part_2 "1mmul(2,3)amull(1,1)mul(1,1))").to eq 7
    end

    it "disables multiplying at start" do
      expect(advent.part_2 "don't()1mmul(2,3)amull(1,1)mul(1,1))").to eq 0
    end

    it "disables and re-enables multiplication" do
      expect(advent.part_2 "don't()1mmul(2,3)amull(1,1)do()mul(2,4))").to eq 8
    end

    it "sample data" do
      input = "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"
      expect(advent.part_2 input).to eq 48
    end

    it "input data" do
      expect(advent.part_2 input_data).to eq 89349241
    end
  end
end
