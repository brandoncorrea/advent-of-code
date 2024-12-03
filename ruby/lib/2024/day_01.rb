class Year_2024_Day_1
  class << self
    def part_1(n)
      distance_between parse_input n
    end

    def part_2(n)
      similarity_score parse_input n
    end

    def similarity_score((left, right))
      left = left.tally
      right = right.tally
      left.map { |n, frequencies|
        similarity_of right, n, frequencies
      }.sum
    end

    def similarity_of(coll, n, frequencies)
      n * frequencies * (coll[n] || 0)
    end

    def distance_between((left, right))
      left = left.sort
      right = right.sort
      left.zip(right)
          .map(&method(:distance))
          .sum
    end

    def distance((a, b))
      (a - b).abs
    end

    def parse_input(input)
      input.chomp_lines
           .flat_map(&:scan_ints)
           .partition
           .with_index { |_, idx| idx.even? }
    end
  end
end
