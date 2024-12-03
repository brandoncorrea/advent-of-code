RE_MUL = /mul\(\d+,\d+\)/
RE_MUL_DO_DONT = /mul\(\d+,\d+\)|do\(\)|don't\(\)/

class Year_2024_Day_3
  class << self
    def part_1(n)
      process_instruction_set RE_MUL, n
     end

    def part_2(n)
      process_instruction_set RE_MUL_DO_DONT, n
    end

    def process_instruction_set(re, memory)
      init = {:sum => 0, :enabled? => true}
      memory
        .scan(re)
        .reduce(init, &method(:process_instruction))
        .fetch(:sum)
    end

    def process_instruction(result, instruction)
      if instruction == "do()"
        result[:enabled?] = true
      elsif instruction == "don't()"
        result[:enabled?] = false
      elsif result[:enabled?]
        result[:sum] += instruction.scan_ints.reduce(&:*)
      end
      result
    end
  end
end
