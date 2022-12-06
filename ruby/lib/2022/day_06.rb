class Year_2022_Day_6
  class << self
    def part_1(data_stream) start_of_marker 4, data_stream end
    def part_2(data_stream) start_of_marker 14, data_stream end

    def start_of_marker(message_length, data_stream)
      marker = ''
      data_stream.each_char.with_index do |char, index|
        marker.include?(char) ?
          marker = reset_marker(marker, char) :
          marker += char
        return index + 1 if marker.length == message_length
      end
      data_stream.length
    end

    def reset_marker(marker, character)
      marker[marker.index(character) + 1..-1] + character
    end
  end
end
