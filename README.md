# TestParseJson


#Create source (Json)

https://www.json-generator.com/

[
  '{{repeat(10)}}',
  {
    id: '{{index()}}',
    firstName: '{{firstName()}}',
    surName: '{{surname()}}',
    age: '{{integer(20, 40)}}',
    lastSession: '{{new Date().getTime()}}'
  }
]