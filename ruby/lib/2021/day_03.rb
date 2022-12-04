class Year_2021_Day_3
  class << self

    def part_1(n)
      return 0 if n.empty?
      binary_counts = binary_counts n.lines.map(&:chomp)
      gamma_rate(binary_counts) * epsilon_rate(binary_counts)
    end

    def binary_counts(lines)
      index_range(lines).map { |index| count_at_index lines, index }
    end

    def gamma_rate(binary_counts)
      rate_by binary_counts, &:<
    end

    def epsilon_rate(binary_counts)
      rate_by binary_counts, &:>
    end

    def rate_by(binary_counts, &should_be_zero)
      binary_counts
        .map { |count| should_be_zero.call(count, 0) ? '0' : '1' }
        .reduce(&:+)
        .to_i(2)
    end

    def part_2(n)
      return 0 if n.empty?
      lines = n.lines.map(&:chomp)
      oxygen_rating(lines) * carbon_rating(lines)
    end

    def oxygen_rating(lines)
      gas_rating lines, &:<
    end

    def carbon_rating(lines)
      gas_rating lines, &:>=
    end

    def gas_rating(lines, &should_be_zero)
      index_range(lines).each do |index|
        count = count_at_index lines, index

        is_desired_number = -> line {
          should_be_zero.call(count, 0) ?
            line[index] == '0' :
            line[index] == '1'
        }

        break if lines.length <= 1 || lines.none?(&is_desired_number)
        lines = lines.select &is_desired_number
      end
      lines[0].to_i(2)
    end

    def count_at_index(lines, index)
      lines.map { |line| line[index] == '1' ? 1 : -1 }.sum
    end

    def index_range(lines)
      (0..lines[0].length - 1)
    end
  end
end
