import Header from "./components/Header";

import Input from "./components/input";
import { useState } from "react";
import List from "./components/List.jsx";

function App() {
  const [userInput, setUserInput] = useState({
    initialInvestment: 10000,
    annualInvestment: 1200,
    expectedReturn: 1000,
    duration: 6,
  });
  function handleInput(identifier, value) {
    setUserInput((pre) => {
      return {
        ...pre,
        [identifier]: +value,
      };
    });
  }

  return (
    <>
      <Header />
      <Input userinput={userInput} onSelect={handleInput} />
      <List userInput={userInput} />
    </>
  );
}

export default App;
