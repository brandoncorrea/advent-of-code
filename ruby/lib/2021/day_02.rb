class Year_2021_Day_2
  class << self
    def part_1(n) final_position :simple_move, n end
    def part_2(n) final_position :aimed_move, n end

    def final_position(move_kw, n)
      n.lines
       .map(&method(:split_movement))
       .reduce([0, 0, 0], &method(move_kw))
       .take(2)
       .reduce(&:*)
    end

    def simple_move((horizontal, vertical), (direction, units))
      case direction
      when "up"
        [horizontal, vertical - units]
      when "down"
        [horizontal, vertical + units]
      else
        [horizontal + units, vertical]
      end
    end

    def aimed_move((horizontal, vertical, aim), (direction, units))
      case direction
      when "up"
        [horizontal, vertical, aim - units]
      when "down"
        [horizontal, vertical, aim + units]
      else
        [horizontal + units, vertical + units * aim, aim]
      end
    end

    def split_movement(movement)
      direction, units = movement.split
      [direction, units.to_i]
    end
  end
end
