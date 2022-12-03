class Year_2022_Day_3
  class << self
    def part_1(n)
      priority_total :slice_by_compartments, n
    end

    def part_2(n)
      priority_total :slice_by_threes, n
    end

    def priority_total(slice_by_kw, rucksacks)
      method(slice_by_kw)
        .call(rucksacks.split("\n"))
        .map(&method(:common_char))
        .map(&method(:char_priority))
        .sum
    end

    def slice_by_compartments(rucksacks)
      rucksacks.map(&method(:split_compartments))
    end

    def slice_by_threes(rucksacks)
      rucksacks.each_slice(3)
    end

    def common_char(n)
      n.first.chars.each do |char|
        return char if n.all? { |nchar| nchar.include?(char) }
      end
    end

    def char_priority(character)
      common_ascii = character.ord
      common_ascii >= 97 ? common_ascii - 96 : common_ascii - 38
    end

    def split_compartments(n)
      split_index = n.length / 2
      [n[0..split_index - 1], n[split_index..-1]]
    end
  end
end
