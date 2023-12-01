class Year_2023_Day_1
  class << self
    @@word_digits = {
      "one" => "1",
      "two" => "2",
      "three" => "3",
      "four" => "4",
      "five" => "5",
      "six" => "6",
      "seven" => "7",
      "eight" => "8",
      "nine" => "9",
    }

    def part_1(n)
      decode_calibrations n, /\d/
    end

    def part_2(n)
      re = /(?=([1-9]|one|two|three|four|five|six|seven|eight|nine))/
      decode_calibrations n, re
    end

    def decode_calibrations(text, re)
      text.split("\n")
          .map { |line| decode_line line, re }
          .reduce(0, &:+)
    end

    def decode_line(line, re)
      digits = line.scan(re).flatten
      digits.first ?
        join_digits(digits.first, digits.last) :
        0
    end

    def join_digits(x, y)
      (to_digit(x) + to_digit(y)).to_i
    end

    def to_digit(n)
      @@word_digits[n] || n
    end
  end
end
