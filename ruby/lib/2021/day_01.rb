class Year_2021_Day_1
  class << self
    def next_window(window_size, coll)
      [coll.take(window_size).sum, coll.drop(1)]
    end

    def increases_by_window_size(window_size, n)
      prev_window, depths = next_window window_size, n.lines.map(&:to_i)
      increases = 0
      until depths.empty?
        cur_window, depths = next_window window_size, depths
        increases += 1 if prev_window < cur_window
        prev_window = cur_window
      end
      increases
    end

    def part_1(n) increases_by_window_size 1, n end
    def part_2(n) increases_by_window_size 3, n end
  end
end
