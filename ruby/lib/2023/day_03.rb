class Year_2023_Day_3
  class << self
    def part_1(schematic)
      lines = schematic.split("\n")
      lines.length
           .times
           .map { |line_no| collect_line_parts lines, line_no }
           .flatten
           .reduce(0, &:+)
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

    def symbol?(char)
      /[^[\d.]]/.match(char)
    end

    def digit?(s)
      /\d/.match(s)
    end

    # def part_2(n) end
  end
end
