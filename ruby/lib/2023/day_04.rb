class Year_2023_Day_4
  class << self
    def part_1(n)
      score_card n
    end

    def score_card(card)
      pow = card.scan(/\d/).uniq.length - 1
      pow >= 0 ? 2 * pow : 0
    end

    # def part_2(n) end
  end
end
