class Year_2023_Day_2
  def initialize(red, green, blue)
    @red = red
    @green = green
    @blue = blue
  end

  def part_1(n)
    string_to_games(n)
      .filter(&method(:possible_game?))
      .map(&:id)
      .sum
  end

  def part_2(n)
    string_to_games(n)
      .map(&:power)
      .sum
  end

  def string_to_games(s)
    s.split("\n")
     .map(&Game.method(:from_string))
  end

  def possible_game?(game)
    game.rounds
        .all?(&method(:possible_round?))
  end

  def possible_round?(round)
    round.blue <= @blue &&
      round.red <= @red &&
      round.green <= @green
  end
end

class Game
  attr_reader :id
  attr_reader :rounds

  def initialize(id)
    @id = id
    @rounds = []
  end

  def add_round(round)
    @rounds << round
  end

  def power
    red = 0
    blue = 0
    green = 0

    for round in @rounds
      red = [red, round.red].max
      blue = [blue, round.blue].max
      green = [green, round.green].max
    end

    red * blue * green
  end

  class << self
    def from_string(s)
      game, rounds = s.split(': ')
      game = Game.new game.split(' ')[1].to_i
      rounds.split(';')
            .map(&Round.method(:from_string))
            .map(&game.method(:add_round))
      game
    end
  end
end

class Round
  attr_accessor :red
  attr_accessor :green
  attr_accessor :blue

  def initialize
    @blue = 0
    @red = 0
    @green = 0
  end

  class << self
    def from_string(s)
      round = Round.new
      for cubes in s.split(',')
        count, color = cubes.split(' ')
        method = (color + "=").to_sym
        round.public_send(method, count.to_i)
      end
      round
    end
  end
end
