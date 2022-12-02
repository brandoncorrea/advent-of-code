require 'fileutils'

def pad_2(n) n.rjust(2, '0') end

def create_lib_file(year, day)
  lib_file = "lib/#{year}/day_#{pad_2(day)}.rb"
  FileUtils.mkdir_p(File.dirname(lib_file))
  unless File.exist?(lib_file)
    File.open(lib_file, 'w') do |file|
      file.write("class Year_#{year}_Day_#{day}
  class << self
    def part_1(n) end

    # def part_2(n) end
  end
end
")
    end
  end
end

def create_spec_file(year, day)
  day_padded = pad_2(day)
  spec_file = "spec/#{year}/day_#{day_padded}_spec.rb"
  FileUtils.mkdir_p(File.dirname(spec_file))
  unless File.exist?(spec_file)
    File.open(spec_file, 'w') do |file|
      file.write(
        "require '#{year}/day_#{day_padded}'

# https://adventofcode.com/#{year}/day/#{day}

describe \"Advent #{year} Day #{day}\" do
  let(:advent) { Year_#{year}_Day_#{day} }

  context \"Part 1\" do
    it \"Solves Part 1\" do
      expect(advent.part_1(1)).to eq -1
    end
  end

  # context \"Part 2\" do
  #   it \"Solves Part 2\" do
  #     expect(advent.part_2(1)).to eq -1
  #   end
  # end
end
")
    end
  end
end

year = ARGV[0]
day = ARGV[1]
create_lib_file(year, day)
create_spec_file(year, day)
