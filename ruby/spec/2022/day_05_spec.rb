require '2022/day_05'

# https://adventofcode.com/2022/day/5

input_data = input_data 2022, 5
sample_data = "    [D]
[N] [C]
[Z] [M] [P]
 1   2   3

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2"

describe "Advent 2022 Day 5" do
  let(:advent) { Year_2022_Day_5 }

  context "Part 1" do
    it "Solves Part 1" do
      expect(advent.part_1(input_data)).to eq "WDLPFNNNB"
    end

    # it "sample data" do
    #   expect(advent.part_1(sample_data)).to eq -1
    # end

    # it "input data" do
    #   expect(advent.part_1(input_data)).to eq -1
    # end
  end

  # context "Part 2" do
  #   it "Solves Part 2" do
  #     expect(advent.part_2(1)).to eq -1
  #   end

  #  # it "sample data" do
  #  #   expect(advent.part_2(sample_data)).to eq -1
  #  # end

  #  # it "input data" do
  #  #   expect(advent.part_2(input_data)).to eq -1
  #  # end
  # end
end
