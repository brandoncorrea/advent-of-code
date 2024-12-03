class Year_2024_Day_2
  class << self
    def part_1(n)
      n.chomp_lines
       .map(&:scan_ints)
       .reject(&:empty?)
       .count(&method(:safe?))
    end

    def safe?(report)
      differences = report.each_cons(2).map(&method(:difference))
      differences.all?(&method(:gradual?)) && progressive?(differences)
    end

    def gradual?(n)
      n.abs <= 3
    end

    def progressive?(coll)
      coll.all?(&:positive?) || coll.all?(&:negative?)
    end

    def difference((a, b))
      a - b
    end

    # def part_2(n) end
  end
end
