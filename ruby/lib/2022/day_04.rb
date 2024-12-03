require 'string'
require 'symbol'

class Year_2022_Day_4
  class << self

    def part_1(n) reconsiderations :fully_contains?, n end
    def part_2(n) reconsiderations :overlapping?, n end

    def reconsiderations(should_reconsider_kw, n)
      n.chomp_lines
       .map(&:scan_ints)
       .count(&method(should_reconsider_kw))
    end

    def fully_contains?((section_1_start, section_1_end, section_2_start, section_2_end))
      section_1_start <= section_2_start && section_2_end <= section_1_end ||
        section_2_start <= section_1_start && section_1_end <= section_2_end
    end

    def overlapping?((section_1_start, section_1_end, section_2_start, section_2_end))
      section_1_start.between?(section_2_start, section_2_end) ||
        section_2_start.between?(section_1_start, section_1_end)
    end
  end
end
