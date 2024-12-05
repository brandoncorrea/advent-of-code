class Year_2024_Day_4
  class << self
    def part_1(n)
      count_matches_by n, "XMAS", :directional_matches_at
    end

    def part_2(n)
      count_matches_by n, "MAS", :x_matches_at
    end

    def count_matches_by(input, word, matches_kw)
      characters = word.split('')
      grid = to_grid input
      grid.length.times.map { |row| matches_along matches_kw, grid, row, characters }.sum
    end

    def x_matches_at(grid, row, col, characters)
      if x_paths_at(row, col).all? { |path| slash_match? grid, path, characters }
        1
      else
        0
      end
    end

    def slash_match?(grid, path, characters)
      valid_path?(grid, path) && bidirectional_match?(grid, path, characters)
    end

    def bidirectional_match?(grid, path, characters)
      word_match?(grid, path, characters) || word_match?(grid, path.reverse, characters)
    end

    def to_grid(input)
      input.chomp_lines.map(&:split.with(''))
    end

    def matches_along(matches_kw, grid, row, characters)
      count_matches = method(matches_kw)
      grid[row].length.times.map { |col| count_matches.call grid, row, col, characters }.sum
    end

    def directional_matches_at(grid, row, col, characters)
      directional_paths_at(row, col, characters)
        .filter { |path| valid_path? grid, path }
        .count { |path| word_match? grid, path, characters }
    end

    def word_match?(grid, path, characters)
      path.map { |(row, col)| grid[row][col] } == characters
    end

    def directional_paths_at(row, col, characters)
      word_direction_vectors.map { |vector| vector_to_path vector, row, col, characters }
    end

    def valid_path?(grid, path)
      path.all? { |coord| in_grid? grid, coord }
    end

    def in_grid?(grid, (row, col))
      row.between?(0, grid.length - 1) && col.between?(0, grid[row].length - 1)
    end

    def word_direction_vectors
      multipliers = [-1, 0, 1]
      multipliers
        .product(multipliers)
        .reject { |pair| pair == [0, 0] }
    end

    def x_paths_at(row, col)
      v1 = (-1..1).map { |i| [row + i, col + i] }
      v2 = (-1..1).map { |i| [row - i, col + i] }
      [v1, v2]
    end

    def vector_to_path((row_track, col_track), row, col, characters)
      characters.length.times.map { |i| [row + row_track * i, col + col_track * i] }.to_a
    end
  end
end
