require '2022/day_02'

# https://adventofcode.com/2022/day/2

describe "Advent 2022 Day 2" do
  context "Part 1" do
    it "No rounds" do
      expect(day_2_part_1("")).to eq 0
    end

    it "One round" do
      expect(day_2_part_1("A X")).to eq 4
    end

    it "Two rounds" do
      expect(day_2_part_1("A X\nB Z")).to eq 13
    end

    it "sample data" do
      data = "A Y\nB X\nC Z"
      expect(day_2_part_1(data)).to eq 15
    end

    it "strategy guide" do
      expect(day_2_part_1(strategy_guide)).to eq 12772
    end

    context "Scoring" do
      it "Rock vs Rock" do
        expect(DAY_2_PART_1_SCORING["A X"]).to eq 4
      end

      it "Rock vs Paper" do
        expect(DAY_2_PART_1_SCORING["A Y"]).to eq 8
      end

      it "Rock vs Scissors" do
        expect(DAY_2_PART_1_SCORING["A Z"]).to eq 3
      end

      it "Paper vs Rock" do
        expect(DAY_2_PART_1_SCORING["B X"]).to eq 1
      end

      it "Paper vs Paper" do
        expect(DAY_2_PART_1_SCORING["B Y"]).to eq 5
      end

      it "Paper vs Scissors" do
        expect(DAY_2_PART_1_SCORING["B Z"]).to eq 9
      end

      it "Scissors vs Rock" do
        expect(DAY_2_PART_1_SCORING["C X"]).to eq 7
      end

      it "Scissors vs Paper" do
        expect(DAY_2_PART_1_SCORING["C Y"]).to eq 2
      end

      it "Scissors vs Scissors" do
        expect(DAY_2_PART_1_SCORING["C Z"]).to eq 6
      end
    end
  end

  context "Part 2" do
    it "no rounds" do
      expect(day_2_part_2('')).to eq 0
    end

    it "one round" do
      expect(day_2_part_2('C Z')).to eq 7
    end

    it "two rounds" do
      expect(day_2_part_2("C Z\nA Y")).to eq 11
    end

    it "base case" do
      data = "A Y\nB X\nC Z"
      expect(day_2_part_2(data)).to eq 12
    end

    it "strategy guide" do
      expect(day_2_part_2(strategy_guide)).to eq 11618
    end

    context "Scoring" do
      it "loss to rock" do
        expect(DAY_2_PART_2_SCORING['A X']).to eq 3
      end

      it "ties with rock" do
        expect(DAY_2_PART_2_SCORING['A Y']).to eq 4
      end

      it "wins against rock" do
        expect(DAY_2_PART_2_SCORING['A Z']).to eq 8
      end

      it "loses to paper" do
        expect(DAY_2_PART_2_SCORING['B X']).to eq 1
      end

      it "ties with paper" do
        expect(DAY_2_PART_2_SCORING['B Y']).to eq 5
      end

      it "wins against paper" do
        expect(DAY_2_PART_2_SCORING['B Z']).to eq 9
      end

      it "loses to scissors" do
        expect(DAY_2_PART_2_SCORING['C X']).to eq 2
      end

      it "ties with scissors" do
        expect(DAY_2_PART_2_SCORING['C Y']).to eq 6
      end

      it "wins against scissors" do
        expect(DAY_2_PART_2_SCORING['C Z']).to eq 7
      end
    end
  end
end
