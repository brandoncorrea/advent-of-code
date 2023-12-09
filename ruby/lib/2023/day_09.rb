class Year_2023_Day_9
  class << self
    def part_1(n)
      extrapolate_history n, :forward_diff, :last
    end

    def part_2(n)
      extrapolate_history n, :backward_diff, :first
    end

    def extrapolate_history(history, diff, nth)
      history
        .split("\n")
        .map(&method(:digits))
        .map { |sequence| neighboring_value sequence, diff, nth }
        .sum
    end

    def neighboring_value(sequence, diff, nth)
      return 0 if sequence.all?(&:zero?)
      diffs = sequence.each_cons(2).map(&method(diff))
      sequence.send(nth) + neighboring_value(diffs, diff, nth)
    end

    def forward_diff((x, y))
      y - x
    end

    def backward_diff((x, y))
      x - y
    end

    def digits(s)
      s.scan(/[-\d]+/).map(&:to_i)
    end
  end
end
