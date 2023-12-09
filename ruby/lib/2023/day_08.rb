class Year_2023_Day_8
  class << self
    def part_1(n)
      traverse_nodes(n, :init_part_1, :all_z?)
    end

    def init_part_1(_)
      ['AAA']
    end

    def all_z?(node)
      node == 'ZZZ'
    end

    def decode_node(line)
      node, left, right = line.scan(/[a-zA-Z\d]+/)
      [node, [left, right]]
    end

    def add_node(nodes, (node, paths))
      nodes[node] = paths
      nodes
    end

    def part_2(n)
      traverse_nodes(n, :nodes_ending_with_a, :end_with_z?)
    end

    def nodes_ending_with_a(lookup)
      lookup.keys.filter { |k| k.end_with?('A') }
    end

    def end_with_z?(node)
      node.end_with?('Z')
    end

    def traverse_nodes(n, init, is_satisfied)
      pattern, _, *node_lines = n.split("\n")
      lookup = node_lines
                 .map(&method(:decode_node))
                 .reduce({}, &method(:add_node))
      step_indices = pattern.each_char.map { |step| step == 'L' ? 0 : 1 }

      steps = 0
      state_nodes = send(init, lookup).uniq
      step_indices.cycle do |step|
        return steps if state_nodes.all?(&method(is_satisfied))
        state_nodes = state_nodes.map { |node| lookup[node][step] }.uniq
        steps += 1
      end
    end
  end
end
