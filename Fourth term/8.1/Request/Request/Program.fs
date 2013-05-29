open System
open System.IO
open System.Net
open System.Text.RegularExpressions

let mainRequest (url: string) = 
    async { let req = WebRequest.Create(url)
        let! resp = req.AsyncGetResponse()
        let stream = resp.getResponseStream()
        let reader = new StreamReader(stream)
        let! html = reader.ReadToEndAsync()
        html }

let subRequest (url: string) = 
    async { let! html = mainRequest(url)
        let regexp = new Regex("<a href=\"http://(.*)\">")
        let matches = regexp.Matches[html]
        let subRequests = [|for i in matches -> i.Value.Substring(9, i.Value.Length() - 3)|]
        let downloads = [|for req in subRequests -> mainRequest(req)|]
        let! results = Async.Parallel downloads
        for i in 1..subRequests.Length() do
            Console.WriteLine(subrequest.[i] + " has length " + results.[i].Length())
          }

