class Year_2023_Day_4
  class << self
    def part_1(n)
      n.split("\n")
       .map(&method(:score_card))
       .sum
    end

    def score_card(card)
      _, winning, mine = card.split(/[:|]/)
      my_numbers = digits mine
      matches = digits(winning)
                  .filter(&my_numbers.method(:include?))
                  .length
      matches.zero? ? 0 : 2 ** (matches - 1)
    end

    def digits(s)
      s.scan(/\d+/).map(&:to_i)
    end

    # def part_2(n) end
  end
end
