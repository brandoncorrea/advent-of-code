class Array
  def rest
    self.drop(1)
  end

  def remove_at(index)
    self[0...index] + self[index.inc..-1]
  end
end
