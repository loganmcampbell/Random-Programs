function frame(position, location, number)
{
  if (position == number)
  {
    clearInterval (location);
  }
  else
  {
      position++;
      element.style.top = position +'px';
      element.style.left = position +'px';
  }
}

function Move()
{
  var element = getElementById("boundary");
  var position = 0;
  var location = setInterval (frame(position,location,200), 2);
  frame(position, location, 200);


}
if (element.style.left == bound)
{
  clearInterval(location);
  element.style.left = 440;
}
else
{
