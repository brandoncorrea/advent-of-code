require 'numeric'
require 'string'
require 'symbol'

class Year_2022_Day_3
  class << self
    def part_1(n) priority :slice_by_compartments, n end

    def part_2(n) priority :slice_by_threes, n end

    def priority(slice_by_kw, rucksacks)
      method(slice_by_kw)
        .call(rucksacks.lines)
        .map(&method(:common_char))
        .map(&method(:char_priority))
        .sum
    end

    def slice_by_compartments(rucksacks)
      rucksacks.map { |rucksack| rucksack.split_at rucksack.length.half }
    end

    def slice_by_threes(rucksacks)
      rucksacks.each_slice(3)
    end

    def common_char(rucksacks)
      rucksacks
        .first
        .chars
        .drop_while { |char| rucksacks.any?(&:exclude?.with(char)) }
        .first
    end

    def char_priority(char)
      char.ord - (char.downcase? ? 96 : 38)
    end
  end
end
