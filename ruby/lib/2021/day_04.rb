require 'symbol'

class Year_2021_Day_4
  class << self
    def part_1(n)
      drawings, boards = parse_input n
      drawings.each do |number|
        call_number boards, number
        winning_board = boards.find(&method(:winner?))
        return board_score winning_board, number if winning_board
      end
      0
    end

    def part_2(n)
      drawings, boards = parse_input n
      drawings.each do |number|
        call_number boards, number
        non_winning_boards = boards.reject(&method(:winner?))
        return board_score boards.last, number if non_winning_boards.empty?
        boards = non_winning_boards
      end
      0
    end

    def board_score(board, last_number)
      board.flatten.compact.reduce(&:+) * last_number
    end

    def call_number(boards, number)
      boards.each do |board|
        board.each_with_index do |row, r|
          row.each_with_index do |col, c|
            board[r][c] = nil if col == number
          end
        end
      end
    end

    def winner?(board)
      board.each_with_index do |_, index|
        return true if board[index].none? || board.map(&:at.with(index)).none?
      end
      false
    end

    def parse_input(n)
      drawings, *boards = n.split "\n\n"
      [drawings.split(',').map(&:to_i),
       boards.map(&method(:parse_board))]
    end

    def parse_board(board)
      board.lines
           .map(&:split)
           .map(&:map.with(&:to_i))
    end
  end
end
