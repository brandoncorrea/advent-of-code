# TODO: Went for speed over cleanliness today – redo this with TDD and clean code

class Year_2022_Day_5
  class << self
    def part_1(n)
      stacks, moves = parse_input n
      moves
        .reduce(stacks, &method(:move_many))
        .map(&:last)
        .reduce(&:+)
    end

    def move_stack(stacks, (crates, from, to))
      while crates > 0
        stacks[to - 1] << stacks[from - 1].pop
        crates -= 1
      end
      stacks
    end

    def move_many(stacks, (crates, from, to))
      crates = stacks[from - 1].pop crates
      crates.each do |crate|
        stacks[to - 1] << crate
      end
      stacks
    end

    def parse_input(n)
      _, moves = n.split("\n\n")

      [
        [
          %w[B P N Q H D R T],
          %w[W G B J T V],
          %w[N R H D S V M Q],
          %w[P Z N M C],
          %w[D Z B],
          %w[V C W Z],
          %w[G Z N C V Q L S],
          %w[L G J M D N V],
          %w[T P M F Z C G],
        ],
        # [
        #   %w[Z N],
        #   %w[M C D],
        #   %w[P]
        # ],
        moves
          .lines
          .map(&:scan.with(/\d+/))
          .map(&:map.with(&:to_i))
      ]
    end

    # def part_2(n) end
  end
end
