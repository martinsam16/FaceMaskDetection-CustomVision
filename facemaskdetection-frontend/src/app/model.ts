export class CustomVisionReturned {
  id: string;
  project: string;
  iteration: string;
  created: string;
  predictions: Array<Prediction>;
}

export class Prediction {
  probability: number;
  tagId: string;
  tagName: string;
}
