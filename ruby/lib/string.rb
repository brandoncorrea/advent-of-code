class String
  def split_at(index)
    [self[0..index - 1], self[index..-1]]
  end

  def exclude?(other_str)
    !self.include?(other_str)
  end

  def chomp_lines
    self.lines(chomp: true)
  end
end