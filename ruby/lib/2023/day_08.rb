class Year_2023_Day_8
  class << self
    def part_1(n)
      pattern, _, *node_lines = n.split("\n")
      nodes = node_lines.map(&method(:decode_node))
      node_lookup = nodes.reduce({}, &method(:add_node))

      steps = 0
      node = 'AAA'
      pattern.each_char.cycle do |step|
        return steps if node == 'ZZZ'
        index = step == 'L' ? 0 : 1
        node = node_lookup[node][index]
        steps += 1
      end
    end

    def decode_node(line)
      node, left, right = line.scan(/[a-zA-Z]+/)
      [node, [left, right]]
    end

    def add_node(nodes, (node, paths))
      nodes[node] = paths
      nodes
    end

    # def part_2(n) end
  end
end
