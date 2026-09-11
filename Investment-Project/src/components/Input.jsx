import { useState } from "react";

export default function Input({ onSelect, userinput }) {
  return (
    <section id="user-input">
      <div className="input-group">
        <p>
          <label>Initial Investment</label>
          <input
            type="number"
            placeholder="Type Here"
            required
            value={userinput.initialInvestment}
            onChange={(e) => onSelect("initialInvestment", e.target.value)}
          />
        </p>
        <p>
          <label>Annual Investment</label>
          <input
            type="number"
            placeholder="Type Here"
            required
            value={userinput.annualInvestment}
            onChange={(e) => onSelect("annualInvestment", e.target.value)}
          />
        </p>
        <p>
          <label>Expected Return</label>
          <input
            type="number"
            placeholder="Type Here"
            required
            value={userinput.expectedReturn}
            onChange={(e) => onSelect("expectedReturn", e.target.value)}
          />
        </p>
        <p>
          <label>Initial Duration</label>
          <input
            type="number"
            placeholder="Type Here"
            required
            value={userinput.duration}
            onChange={(e) => onSelect("duration", e.target.value)}
          />
        </p>
      </div>
    </section>
  );
}
