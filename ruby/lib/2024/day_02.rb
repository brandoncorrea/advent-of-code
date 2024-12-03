class Year_2024_Day_2
  class << self
    def part_1(n)
      count_reports_by :safe?, n
    end

    def part_2(n)
      count_reports_by :tolerable?, n
    end

    def count_reports_by(pred, n)
      n.chomp_lines
       .map(&:scan_ints)
       .reject(&:empty?)
       .count(&method(pred))
    end

    def tolerable?(report)
      report.size
            .times
            .map { |index| report.remove_at index }
            .any?(&method(:safe?))
    end

    def safe?(report)
      differences = report.each_cons(2).map { |(a, b)| a - b }
      gradual?(differences) && progressive?(differences)
    end

    def gradual?(differences)
      differences
        .map(&:abs)
        .all?(&:<=.with(3))
    end

    def progressive?(differences)
      differences.all?(&:positive?) || differences.all?(&:negative?)
    end
  end
end
