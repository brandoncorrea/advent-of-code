require 'symbol'

class Year_2021_Day_3
  class << self

    def part_1(n)
      diagnostics = n.lines.map(&:chomp)
      index_range(diagnostics)
        .reduce(["", ""]) { |ratings, index| update_gamma_epsilon ratings, diagnostics, index }
        .map(&:to_i.with(2))
        .reduce(&:*)
    end

    def update_gamma_epsilon((gamma, epsilon), diagnostics, index)
      charge_at_index(diagnostics, index).positive? ?
        [gamma + '1', epsilon + '0'] :
        [gamma + '0', epsilon + '1']
    end

    def part_2(n)
      return 0 if n.empty?
      diagnostics = n.lines.map(&:chomp)
      gas_rating(diagnostics, &:<) * gas_rating(diagnostics, &:>=)
    end

    def gas_rating(diagnostics, &should_be_zero)
      index_range(diagnostics).each do |index|
        charge = charge_at_index diagnostics, index

        is_desired_number = -> diagnostic {
          should_be_zero.call(charge, 0) ?
            diagnostic[index] == '0' :
            diagnostic[index] == '1'
        }

        break if diagnostics.length <= 1 || diagnostics.none?(&is_desired_number)
        diagnostics = diagnostics.select &is_desired_number
      end
      diagnostics[0].to_i(2)
    end

    def charge_at_index(diagnostics, index)
      diagnostics.map { |diagnostic| diagnostic[index] == '1' ? 1 : -1 }.sum
    end

    def index_range(diagnostics)
      diagnostics.empty? ? [] : (0..diagnostics[0].length - 1)
    end
  end
end
