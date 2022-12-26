require 'fileutils'
require './lib/symbol'

LIB_CONTENT = "class Year_%<year>d_Day_%<day>d
  class << self
    def part_1(n) end

    # def part_2(n) end
  end
end
"

SPEC_CONTENT = %q[require '%<year>d/day_%<day>02d'

# https://adventofcode.com/%<year>d/day/%<day>d

input_data = input_data %<year>d, %<day>d
sample_data = sample_data %<year>d, %<day>d

describe "Advent %<year>d Day %<day>d" do
  let(:advent) { Year_%<year>d_Day_%<day>d }

  context "Part 1" do
    it "Solves Part 1" do
      expect(advent.part_1 "").to eq -1
    end

    # it "sample data" do
    #   expect(advent.part_1 sample_data).to eq -1
    # end

    # it "input data" do
    #   expect(advent.part_1 input_data).to eq -1
    # end
  end

  # context "Part 2" do
  #   it "Solves Part 2" do
  #     expect(advent.part_2 "").to eq -1
  #   end

  #  # it "sample data" do
  #  #   expect(advent.part_2 sample_data).to eq -1
  #  # end

  #  # it "input data" do
  #  #   expect(advent.part_2 input_data).to eq -1
  #  # end
  # end
end
]

def write_content(path, content_format, year, day)
  File.open path, 'w', &:write.with(content_format % {year: year, day: day})
end

def create_file(path_format, content_format, year, day)
  path = path_format % [year, day]
  FileUtils.mkdir_p File.dirname path
  write_content path, content_format, year, day unless File.exist? path
end

year = ARGV[0]
day = ARGV[1]
create_file "lib/%d/day_%02d.rb", LIB_CONTENT, year, day
create_file "spec/%d/day_%02d_spec.rb", SPEC_CONTENT, year, day
