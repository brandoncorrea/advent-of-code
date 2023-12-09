class Year_2023_Day_3
  class << self
    def part_1(schematic)
      lines = schematic.split("\n")
      lines.length
           .times
           .map { |line_no| collect_line_parts lines, line_no }
           .flatten
           .sum
    end

    def collect_line_parts(lines, line_no)
      parts = []
      start = 0
      while start < lines[line_no].length
        start, part = collect_next_part lines, line_no, start
        parts << part if part
      end
      parts
    end

    def collect_next_part(lines, line_no, start)
      line = lines[line_no]
      if digit?(line[start])
        stop = seek_part_end line, start

        if part_number?(lines, line_no, start, stop)
          return stop + 1, line[start..stop].to_i
        end
      end
      start + 1
    end

    def seek_part_end(line, stop)
      idx = stop + 1

      while idx < line.length
        return stop unless digit?(line[idx])
        stop = idx
        idx += 1
      end

      stop
    end

    def part_number?(lines, line_no, start, stop)
      surrounding_coordinates(lines.length, lines[line_no].length, line_no, start, stop)
        .map { |(row, col)| lines[row][col] }
        .any?(&method(:symbol?))
    end

    def surrounding_coordinates(line_count, line_length, line_no, start, stop)
      coordinates = []
      if start > 0
        start_bound = start - 1
        coordinates << [line_no, start_bound]
      else
        start_bound = start
      end

      if stop < line_length - 1
        stop_bound = stop + 1
        coordinates << [line_no, stop_bound]
      else
        stop_bound = stop
      end

      if line_no > 0
        coordinates += coordinates_between(line_no - 1, start_bound, stop_bound)
      end

      if line_no < line_count - 1
        coordinates += coordinates_between(line_no + 1, start_bound, stop_bound)
      end

      coordinates
    end

    def coordinates_between(line_no, start, stop)
      (start..stop)
        .each
        .map { |index| [line_no, index] }
    end

    def part_2(n)
      sum = 0
      lines = n.split("\n")
      lines.each_with_index do |line, line_no|
        line.each_char.with_index do |char, char_no|
          if char == '*'
            sum += gear_ratio lines, line_no, char_no
          end
        end
      end
      sum
    end

    def gear_ratio(lines, line_no, char_no)
      parts = adjacent_parts lines, line_no, char_no
      if parts.length == 2
        parts[0] * parts[1]
      else
        0
      end
    end

    def adjacent_parts(lines, line_no, index)
      min = line_no == 0 ? line_no : line_no - 1
      max = line_no == lines.length - 1 ? line_no : line_no + 1
      (min..max)
        .map { |line| part_numbers lines[line], index }
        .flatten
        .map(&:to_i)
    end

    def part_numbers(line, index)
      left = right = index
      left -= 1 while left > 0 && digit?(line[left - 1])
      right += 1 while right < line.length - 1 && digit?(line[right + 1])
      digits line[left..right]
    end

    def digits(s)
      s.scan(/\d+/)
    end

    def symbol?(char)
      /[^[\d.]]/.match?(char)
    end

    def digit?(s)
      /\d/.match?(s)
    end
  end
end
