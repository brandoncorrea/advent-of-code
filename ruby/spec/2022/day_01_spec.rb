require '2022/day_01'

# https://adventofcode.com/2022/day/1

describe "Advent 2022 Day 1" do
  context "part 1" do
    it "No elves" do
      expect(part_1("")).to eq 0
    end

    it "one elf with no calories" do
      expect(part_1("0")).to eq 0
    end

    it "one elf with one calorie" do
      expect(part_1("1")).to eq 1
    end

    it "one elf with two calories" do
      expect(part_1("2")).to eq 2
    end

    it "one elf with two rations, one being zero" do
      expect(part_1("10\n0")).to eq 10
    end

    it "one elf with two rations" do
      expect(part_1("10\n20")).to eq 30
    end

    it "two elves with one ration" do
      expect(part_1("1\n\n1")).to eq 1
    end

    it "two elves with differing rations" do
      expect(part_1("1\n\n2")).to eq 2
    end

    it "two elves with differing rations" do
      expect(part_1("1000\n2000\n3000\n\n4000\n\n5000\n6000\n\n7000\n8000\n9000\n\n10000")).to eq 24000
    end

    it "my test data" do
      expect(part_1(input_data(2022, 1))).to eq 72511
    end
  end

  context "part 2" do
    it "no elves" do
      expect(part_2("")).to eq 0
    end

    it "one elf with no calories" do
      expect(part_2("0")).to eq 0
    end

    it "one elf with one calorie" do
      expect(part_2("1")).to eq 1
    end

    it "two elves with one calorie" do
      expect(part_2("1\n\n1")).to eq 2
    end

    it "three elves with 1, 2, and 3 calories" do
      expect(part_2("1\n\n2\n\n3")).to eq 6
    end

    it "four elves with 1, 2, 3, and 4 calories" do
      expect(part_2("1\n\n2\n\n3\n\n4")).to eq 9
    end

    it "base case" do
      expect(part_2("1000\n2000\n3000\n\n4000\n\n5000\n6000\n\n7000\n8000\n9000\n\n10000")).to eq 45000
    end

    it "my test data" do
      expect(part_2(input_data(2022, 1))).to eq 212117
    end
  end
end
