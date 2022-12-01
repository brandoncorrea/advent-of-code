require 'fileutils'

def pad_2(n) n.rjust(2, '0') end

def create_lib_file(year, day)
  lib_file = "lib/#{year}/day_#{pad_2(day)}.rb"
  FileUtils.mkdir_p(File.dirname(lib_file))
  unless File.exist?(lib_file)
    File.open(lib_file, 'w') do |file|
      file.write("def day_#{day}(n)\n  \nend\n")
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
  it \"Solves Day #{day}\" do
    expect(day_#{day}(1)).to eq 1
  end
end
")
    end
  end
end

year = ARGV[0]
day = ARGV[1]
create_lib_file(year, day)
create_spec_file(year, day)
