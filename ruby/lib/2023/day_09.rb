class Year_2023_Day_9
  class << self
    def part_1(n)
      n.split("\n")
       .map(&method(:digits))
       .map(&method(:next_value))
       .reduce(0, :+)
    end

    def next_value(sequence)
      return 0 if sequence.all?(&:zero?)
      diffs = sequence.each_cons(2).map(&method(:diff))
      sequence.last + next_value(diffs)
    end

    def diff((x, y))
      (y - x)
    end

    def digits(s)
      s.scan(/[-\d]+/).map(&:to_i)
    end

    # def part_2(n) end
  end
end
